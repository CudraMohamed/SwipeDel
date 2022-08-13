package cudra.mohamed.swipedel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseRVAdapter (var courseList:ArrayList<CourseRVModal>,var context:Context):RecyclerView.Adapter<CourseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.course_item_list,parent,false))
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.courseNameTV.text=courseList.get(position).courseName
        holder.courseIv.setImageResource(courseList.get(position).courseImg)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CourseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var courseNameTV:TextView=itemView.findViewById(R.id.tvCourse)
    var courseIv:ImageView=itemView.findViewById(R.id.ivCourse)
}