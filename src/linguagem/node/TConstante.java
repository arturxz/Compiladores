/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.node;

import linguagem.analysis.*;

@SuppressWarnings("nls")
public final class TConstante extends Token
{
    public TConstante()
    {
        super.setText("constante");
    }

    public TConstante(int line, int pos)
    {
        super.setText("constante");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TConstante(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTConstante(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TConstante text.");
    }
}
