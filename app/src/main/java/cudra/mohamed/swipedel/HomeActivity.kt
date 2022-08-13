package cudra.mohamed.swipedel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    lateinit var rvCourses:RecyclerView
    lateinit var courseRVAdapter:CourseRVAdapter
    lateinit var courseList:ArrayList<CourseRVModal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvCourses=findViewById(R.id.ivCourse)

        courseList=ArrayList()

        courseRVAdapter = CourseRVAdapter(courseList,this)

        rvCourses.adapter =courseRVAdapter

        courseList.add(CourseRVModal("Android Development",R.drawable.kotlin))
        courseList.add(CourseRVModal("Python Development",R.drawable.python))
        courseList.add(CourseRVModal("JavaScript Development",R.drawable.js))
        courseList.add(CourseRVModal("Game Development",R.drawable.game))

        courseRVAdapter.notifyDataSetChanged()

        ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deleteCourse:CourseRVModal=courseList.get(viewHolder.adapterPosition)

                val position=viewHolder.adapterPosition

                courseList.removeAt(viewHolder.adapterPosition)

                courseRVAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                Snackbar.make(rvCourses,"Deleted "+ deleteCourse.courseName,Snackbar.LENGTH_LONG)
                    .setAction(
                        "Undo",
                        View.OnClickListener {
                            courseList.add(position,deleteCourse)

                            courseRVAdapter.notifyItemInserted(position)
                        }
                    ).show()
            }
        }).attachToRecyclerView(rvCourses)
    }
}