/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AExpAriCommAvalie extends PCommAvalie
{
    private PExp _exp_;
    private PCommAvalieCasoParte _commAvalieCasoParte_;

    public AExpAriCommAvalie()
    {
        // Constructor
    }

    public AExpAriCommAvalie(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") PCommAvalieCasoParte _commAvalieCasoParte_)
    {
        // Constructor
        setExp(_exp_);

        setCommAvalieCasoParte(_commAvalieCasoParte_);

    }

    @Override
    public Object clone()
    {
        return new AExpAriCommAvalie(
            cloneNode(this._exp_),
            cloneNode(this._commAvalieCasoParte_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpAriCommAvalie(this);
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

    public PCommAvalieCasoParte getCommAvalieCasoParte()
    {
        return this._commAvalieCasoParte_;
    }

    public void setCommAvalieCasoParte(PCommAvalieCasoParte node)
    {
        if(this._commAvalieCasoParte_ != null)
        {
            this._commAvalieCasoParte_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commAvalieCasoParte_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._commAvalieCasoParte_);
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

        if(this._commAvalieCasoParte_ == child)
        {
            this._commAvalieCasoParte_ = null;
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

        if(this._commAvalieCasoParte_ == oldChild)
        {
            setCommAvalieCasoParte((PCommAvalieCasoParte) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}