/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class TDe extends Token
{
    public TDe()
    {
        super.setText("de");
    }

    public TDe(int line, int pos)
    {
        super.setText("de");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDe(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDe(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDe text.");
    }
}
