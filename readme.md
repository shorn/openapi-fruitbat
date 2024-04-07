Demonstrate a problem with OpenAPI 3.1 code generation for enums that are
defined via a `$ref`.

See https://github.com/OpenAPITools/openapi-generator/issues/17026

Shows the problem with Enum classes not being shared across types when
generating code where the type is pulled in from a different file via a `$ref`.

The Vegetable enum type will be generated as a nested enum class on each
endpoint return type. It is duplicated across VegetablePallet and
VegetableBasket classes, and thus the `type` field of each class is not
shared.  This is demonstrated for both Java and Typescript generation.

The `Vegetable` types are not assignment compatible. In Typescript you could
get away with the generated code because of structural typing, but Java has
only nominal typing.
The two "Vegetable" class are not the same, they cannot be assigned to the
same variables, parameters, generic types, etc.

* `shared-enum-3.1` shows the problem with openapi `3.1.0`
* `shared-enum-3.0` shows that correct code is generated if using openapi `3.0.3`