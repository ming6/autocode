package com.github.ming6.autocode.core;

public interface Coder<IP, OP> {
	
	public void coding(CodeInput<IP> input, CodeOutput<OP> output);
	
}