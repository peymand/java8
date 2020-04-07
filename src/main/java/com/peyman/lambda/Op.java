package com.peyman.lambda;

@FunctionalInterface
public interface Op {
    void runOp();
}
//Q: what is the type of Math:sin
//A: can determine from context only
//Method Refrence
/*
someClass::staticMethod Equivalent
someObject:InstanceMethod
someClass::InstanceMethod
someClass::new
*
*
*
* */