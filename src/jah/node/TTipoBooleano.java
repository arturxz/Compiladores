/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class TTipoBooleano extends Token
{
    public TTipoBooleano()
    {
        super.setText("bool");
    }

    public TTipoBooleano(int line, int pos)
    {
        super.setText("bool");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTipoBooleano(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTipoBooleano(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTipoBooleano text.");
    }
}
