package org.metaborg.lang.tiger.ninterpreter.terms;

import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;

public final class Var_1 extends Var {
	public final static String CONSTRUCTOR = "Var";

	public final static int ARITY = 1;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(CONSTRUCTOR);
		sb.append("(");
		sb.append(_1);
		sb.append(")");
		return sb.toString();
	}

	private Var_1(Occ _1) {
		this._1 = _1;
	}

	private final Occ _1;

	public Occ get_1() {
		return _1;
	}

	public String getId() {
		return _1.getId();
	}

	public static Var_1 create(IStrategoTerm term) {
		assert term != null;
		assert Tools.isTermAppl(term);
		assert Tools.hasConstructor((IStrategoAppl) term, CONSTRUCTOR, ARITY);
		return new Var_1(Occ.create(term.getSubterm(0)));
	}
}