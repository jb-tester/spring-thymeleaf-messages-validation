# support references in ValidationUtils methods

https://youtrack.jetbrains.com/issue/IDEA-357507

see `PersonValidator` class: actually there are no references to the property keys from the 
`ValidationUtils.rejectIfEmpty()` method parameter;

also the references could be provided for the `Error.rejectValue()` method.

If possible, the `field` parameter values could be treated as references also.


`home.html`: quickfix to create a property doesn't work

https://youtrack.jetbrains.com/issue/IDEA-357662/Create-Property-intention-for-missing-property-key-doesnt-allow-to-select-the-local-resource-bundle