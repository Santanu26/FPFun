# FPFun
Some fun with functional programming.

1. Key point is: <b>always extract complex lambdas into functions with an expressive name</b> that you can then reference using 
four dots(::) from:
  the same class (this::)
  another class(mapper::)
  some sttaic helper method(SomeClass::)
  the Stream *item* type (Item::)
  even some constructor(UserDto::new) . if it's simple enough
  
  <b>never type -> {</b>
