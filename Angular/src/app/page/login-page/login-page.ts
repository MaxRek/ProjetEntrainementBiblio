import { Component, OnInit } from '@angular/core';
import { AuthRequestDto } from '../../dto/auth-request-dto';
import { AuthService } from '../../service/auth-service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  imports: [ReactiveFormsModule],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css',
})
export class LoginPage implements OnInit {
  protected userForm!: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder) { }

ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      login: this.formBuilder.control(''),
      mdp: this.formBuilder.control('')
    })
}

  public connecter() {
    this.authService.auth(new AuthRequestDto(this.userForm.value.login,this.userForm.value.mdp));
  }
}
