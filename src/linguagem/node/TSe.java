/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.node;

import linguagem.analysis.*;

@SuppressWarnings("nls")
public final class TSe extends Token
{
    public TSe()
    {
        super.setText("se");
    }

    public TSe(int line, int pos)
    {
        super.setText("se");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSe(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSe(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSe text.");
    }
}
