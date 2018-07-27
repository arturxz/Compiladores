/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AExpDivExpExp extends PExp
{
    private PExp _exp_;
    private TDiv _div_;
    private PPosExp _posExp_;

    public AExpDivExpExp()
    {
        // Constructor
    }

    public AExpDivExpExp(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TDiv _div_,
        @SuppressWarnings("hiding") PPosExp _posExp_)
    {
        // Constructor
        setExp(_exp_);

        setDiv(_div_);

        setPosExp(_posExp_);

    }

    @Override
    public Object clone()
    {
        return new AExpDivExpExp(
            cloneNode(this._exp_),
            cloneNode(this._div_),
            cloneNode(this._posExp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpDivExpExp(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TDiv getDiv()
    {
        return this._div_;
    }

    public void setDiv(TDiv node)
    {
        if(this._div_ != null)
        {
            this._div_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._div_ = node;
    }

    public PPosExp getPosExp()
    {
        return this._posExp_;
    }

    public void setPosExp(PPosExp node)
    {
        if(this._posExp_ != null)
        {
            this._posExp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._posExp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._div_)
            + toString(this._posExp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._div_ == child)
        {
            this._div_ = null;
            return;
        }

        if(this._posExp_ == child)
        {
            this._posExp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._div_ == oldChild)
        {
            setDiv((TDiv) newChild);
            return;
        }

        if(this._posExp_ == oldChild)
        {
            setPosExp((PPosExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
