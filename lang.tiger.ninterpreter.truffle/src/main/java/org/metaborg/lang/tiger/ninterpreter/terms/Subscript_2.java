package org.metaborg.lang.tiger.ninterpreter.terms;

import org.metaborg.lang.tiger.ninterpreter.truffle.TigerEnv;
import org.metaborg.lang.tiger.ninterpreter.truffle.nodes.bindings.LValue;
import org.metaborg.lang.tiger.ninterpreter.truffle.objects.ArrayV;
import org.metaborg.lang.tiger.ninterpreter.truffle.objects.IntV;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;

public final class Subscript_2 extends LValue {
	public final static String CONSTRUCTOR = "Subscript";

	public final static int ARITY = 2;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(CONSTRUCTOR);
		sb.append("(");
		sb.append(_1);
		sb.append(", ");
		sb.append(_2);
		sb.append(")");
		return sb.toString();
	}

	@Override
	public Object evaluate(TigerEnv env) {
		int arrAddr = (int) _1.evaluate(env);
		IntV idxV = (IntV) _2.evaluate(env);
		ArrayV arr = (ArrayV) context().heap().read(arrAddr);
		return arr.get(idxV.value());
	}

	private Subscript_2(LValue _1, Index _2) {
		this._1 = _1;
		this._2 = _2;
	}

	private final LValue _1;

	private final Index _2;

	public LValue get_1() {
		return _1;
	}

	public Index get_2() {
		return _2;
	}

	public static Subscript_2 create(IStrategoTerm term) {
		assert term != null;
		assert Tools.isTermAppl(term);
		assert Tools.hasConstructor((IStrategoAppl) term, CONSTRUCTOR, ARITY);
		return new Subscript_2(LValue.create(term.getSubterm(0)), Index.create(term.getSubterm(1)));
	}
}