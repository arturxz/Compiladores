/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class TFimPrograma extends Token
{
    public TFimPrograma()
    {
        super.setText("fim.");
    }

    public TFimPrograma(int line, int pos)
    {
        super.setText("fim.");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TFimPrograma(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTFimPrograma(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TFimPrograma text.");
    }
}
