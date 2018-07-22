/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.node;

import linguagem.analysis.*;

@SuppressWarnings("nls")
public final class ATerminalFator extends PFator
{
    private PTerminal _terminal_;

    public ATerminalFator()
    {
        // Constructor
    }

    public ATerminalFator(
        @SuppressWarnings("hiding") PTerminal _terminal_)
    {
        // Constructor
        setTerminal(_terminal_);

    }

    @Override
    public Object clone()
    {
        return new ATerminalFator(
            cloneNode(this._terminal_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATerminalFator(this);
    }

    public PTerminal getTerminal()
    {
        return this._terminal_;
    }

    public void setTerminal(PTerminal node)
    {
        if(this._terminal_ != null)
        {
            this._terminal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._terminal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._terminal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._terminal_ == child)
        {
            this._terminal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._terminal_ == oldChild)
        {
            setTerminal((PTerminal) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
