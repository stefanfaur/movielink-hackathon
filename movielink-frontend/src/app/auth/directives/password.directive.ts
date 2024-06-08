import { Directive } from '@angular/core';
import { NG_VALIDATORS, AbstractControl, ValidationErrors, Validator } from '@angular/forms';
import { passwordValidator } from '../validators/password.validator';

@Directive({
  selector: '[appPasswordValidator]',
  standalone: true,
  providers: [{provide: NG_VALIDATORS, useExisting: PasswordValidatorDirective, multi: true}]
})
export class PasswordValidatorDirective implements Validator {
  validate(control: AbstractControl): ValidationErrors | null {
    return passwordValidator()(control);
  }
}
