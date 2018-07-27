/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AExpMenorExpExpLogica extends PExpLogica
{
    private PExp _exp_;
    private TMenor _menor_;
    private PPosExp _posExp_;

    public AExpMenorExpExpLogica()
    {
        // Constructor
    }

    public AExpMenorExpExpLogica(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TMenor _menor_,
        @SuppressWarnings("hiding") PPosExp _posExp_)
    {
        // Constructor
        setExp(_exp_);

        setMenor(_menor_);

        setPosExp(_posExp_);

    }

    @Override
    public Object clone()
    {
        return new AExpMenorExpExpLogica(
            cloneNode(this._exp_),
            cloneNode(this._menor_),
            cloneNode(this._posExp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpMenorExpExpLogica(this);
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

    public TMenor getMenor()
    {
        return this._menor_;
    }

    public void setMenor(TMenor node)
    {
        if(this._menor_ != null)
        {
            this._menor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._menor_ = node;
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
            + toString(this._menor_)
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

        if(this._menor_ == child)
        {
            this._menor_ = null;
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

        if(this._menor_ == oldChild)
        {
            setMenor((TMenor) newChild);
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
