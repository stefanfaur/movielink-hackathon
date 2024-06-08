import { Directive } from '@angular/core';
import { NG_VALIDATORS, AbstractControl, ValidationErrors, Validator } from '@angular/forms';
import { fullNameValidator } from '../validators/full-name.validator';

@Directive({
  selector: '[appFullNameValidator]',
  standalone: true,
  providers: [{provide: NG_VALIDATORS, useExisting: FullNameValidatorDirective, multi: true}]
})
export class FullNameValidatorDirective implements Validator {
  validate(control: AbstractControl): ValidationErrors | null {
    return fullNameValidator()(control);
  }
}
