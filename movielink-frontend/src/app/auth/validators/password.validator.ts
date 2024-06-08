import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function passwordValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value;
    if (!value) return null;

    const isValid = value.length >= 8 && /[^A-Za-z0-9]/.test(value);
    return isValid ? null : { password: true };
  };
}
