/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.node;

import linguagem.analysis.*;

@SuppressWarnings("nls")
public final class TPontoVirgula extends Token
{
    public TPontoVirgula(String text)
    {
        setText(text);
    }

    public TPontoVirgula(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPontoVirgula(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPontoVirgula(this);
    }
}
