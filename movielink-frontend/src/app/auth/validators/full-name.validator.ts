import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function fullNameValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value;
    if (!value) return null;

    const names = value.trim().split(' ');
    const namePattern = /^[A-Za-z]+$/;

    const isValid = names.length >= 2 && names.every((name: string) => namePattern.test(name));
    return isValid ? null : { fullName: true };
  };
}
