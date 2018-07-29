/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AOprsDesLogica extends PDesLogica
{
    private POprLogica _oprLogica_;

    public AOprsDesLogica()
    {
        // Constructor
    }

    public AOprsDesLogica(
        @SuppressWarnings("hiding") POprLogica _oprLogica_)
    {
        // Constructor
        setOprLogica(_oprLogica_);

    }

    @Override
    public Object clone()
    {
        return new AOprsDesLogica(
            cloneNode(this._oprLogica_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOprsDesLogica(this);
    }

    public POprLogica getOprLogica()
    {
        return this._oprLogica_;
    }

    public void setOprLogica(POprLogica node)
    {
        if(this._oprLogica_ != null)
        {
            this._oprLogica_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._oprLogica_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._oprLogica_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._oprLogica_ == child)
        {
            this._oprLogica_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._oprLogica_ == oldChild)
        {
            setOprLogica((POprLogica) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
