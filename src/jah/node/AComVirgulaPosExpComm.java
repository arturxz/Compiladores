/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AComVirgulaPosExpComm extends PPosExpComm
{
    private PExp _exp_;
    private TVirgula _virgula_;
    private PPosExp _posExp_;

    public AComVirgulaPosExpComm()
    {
        // Constructor
    }

    public AComVirgulaPosExpComm(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TVirgula _virgula_,
        @SuppressWarnings("hiding") PPosExp _posExp_)
    {
        // Constructor
        setExp(_exp_);

        setVirgula(_virgula_);

        setPosExp(_posExp_);

    }

    @Override
    public Object clone()
    {
        return new AComVirgulaPosExpComm(
            cloneNode(this._exp_),
            cloneNode(this._virgula_),
            cloneNode(this._posExp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComVirgulaPosExpComm(this);
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

    public TVirgula getVirgula()
    {
        return this._virgula_;
    }

    public void setVirgula(TVirgula node)
    {
        if(this._virgula_ != null)
        {
            this._virgula_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._virgula_ = node;
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
            + toString(this._virgula_)
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

        if(this._virgula_ == child)
        {
            this._virgula_ = null;
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

        if(this._virgula_ == oldChild)
        {
            setVirgula((TVirgula) newChild);
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
