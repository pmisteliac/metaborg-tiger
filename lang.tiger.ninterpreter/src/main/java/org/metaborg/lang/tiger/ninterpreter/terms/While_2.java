package org.metaborg.lang.tiger.ninterpreter.terms;

import org.metaborg.lang.tiger.ninterpreter.TigerEnv;
import org.metaborg.lang.tiger.ninterpreter.objects.BreakException;
import org.metaborg.lang.tiger.ninterpreter.objects.IntV;
import org.metaborg.lang.tiger.ninterpreter.objects.UnitV;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;

public final class While_2 extends Exp {
	public final static String CONSTRUCTOR = "While";

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
		while (((IntV) _1.evaluate(env)).value() == 1) {
			try {
				_2.evaluate(env);
			} catch (BreakException brex) {
				break;
			}
		}
		return new UnitV();
	}

	private While_2(Exp _1, Exp _2) {
		this._1 = _1;
		this._2 = _2;
	}

	private final Exp _1;

	private final Exp _2;

	public Exp get_1() {
		return _1;
	}

	public Exp get_2() {
		return _2;
	}

	public static While_2 create(IStrategoTerm term) {
		assert term != null;
		assert Tools.isTermAppl(term);
		assert Tools.hasConstructor((IStrategoAppl) term, CONSTRUCTOR, ARITY);
		return new While_2(Exp.create(term.getSubterm(0)), Exp.create(term.getSubterm(1)));
	}
}