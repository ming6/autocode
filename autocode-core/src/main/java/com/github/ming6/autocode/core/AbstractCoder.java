package com.github.ming6.autocode.core;

public abstract class AbstractCoder<IP, OP> implements Coder<IP, OP> {

	public abstract OP convert(IP inputParam);
	
	public void coding(CodeInput<IP> input, CodeOutput<OP> output) {
		IP inputParam = input.read();
		output.write(convert(inputParam));
	}
}