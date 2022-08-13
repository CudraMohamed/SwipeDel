package cudra.mohamed.swipedel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cudra.mohamed.swipedel.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }
        binding.tvLogIn.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSignUp(){
        var firstname = binding.etFirstName.text.toString()
        var lastname = binding.etLastName.text.toString()
        var signupEmail = binding.etSignUpEmail.text.toString()
        var signupPassword = binding.etSignUpPassword.text.toString()
        var signUpConfirmP = binding.etSignUpConfirm.text.toString()

        if (firstname.isBlank()){
            binding.tilFirstName.error = "First Name Required"
        }
        if (lastname.isBlank()){
            binding.tilLastName.error = "Last Name Required"
        }
        if (signupEmail.isBlank()){
            binding.tilSignUpEmail.error = "Email Required"
        }
        if (signupPassword.isBlank()){
            binding.tilSignUpPassword.error = "Password Required"
        }
        if (signupPassword.length<8){
            binding.tilSignUpPassword.error = "Password is too Short"
        }
        if (signupPassword.length>16){
            binding.tilSignUpPassword.error = "Password is too Long"
        }
        if (signUpConfirmP.isBlank()){
            binding.tilSignUpConfirm.error = "Password Confirmation Required"
        }
        if (signUpConfirmP!=signupPassword){
            binding.tilSignUpConfirm.error = "Password does not match"
        }
        else if (signUpConfirmP.length<8){
            binding.tilSignUpConfirm.error = "Password too short"
        }
        else if (signUpConfirmP.length>16){
            binding.tilSignUpConfirm.error = "Password too long"
        }
    }

}