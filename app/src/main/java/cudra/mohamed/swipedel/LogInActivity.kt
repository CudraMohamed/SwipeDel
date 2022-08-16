package cudra.mohamed.swipedel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import cudra.mohamed.swipedel.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLogInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogIn.setOnClickListener {
            validateLogIn()
            finish()
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()

        }
    }
    fun validateLogIn(){
        var email=binding.etEmailL.text.toString()
        var password=binding.etPasswordL.text.toString()
        var error=false

        if(email.isBlank()){
            binding.tilEmailL.error="Email is required"
            error=true
        }
        else if(password.isBlank()){
            binding.tilPasswordL.error="Password is required"
            error=true
        }
        else if(password.length<8){
            binding.tilPasswordL.error="Password is too short"
            error=true
        }
        else if(password.length>16){
            binding.tilPasswordL.error="Password is too long"
        }
        if(!error){
            startActivity(Intent(this,HomeActivity::class.java))
            binding.imgLogo
        }
    }
}