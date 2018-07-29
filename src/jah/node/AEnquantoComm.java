/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AEnquantoComm extends PComm
{
    private PCommEnquanto _commEnquanto_;

    public AEnquantoComm()
    {
        // Constructor
    }

    public AEnquantoComm(
        @SuppressWarnings("hiding") PCommEnquanto _commEnquanto_)
    {
        // Constructor
        setCommEnquanto(_commEnquanto_);

    }

    @Override
    public Object clone()
    {
        return new AEnquantoComm(
            cloneNode(this._commEnquanto_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEnquantoComm(this);
    }

    public PCommEnquanto getCommEnquanto()
    {
        return this._commEnquanto_;
    }

    public void setCommEnquanto(PCommEnquanto node)
    {
        if(this._commEnquanto_ != null)
        {
            this._commEnquanto_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commEnquanto_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._commEnquanto_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._commEnquanto_ == child)
        {
            this._commEnquanto_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._commEnquanto_ == oldChild)
        {
            setCommEnquanto((PCommEnquanto) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
