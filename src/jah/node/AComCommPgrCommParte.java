/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AComCommPgrCommParte extends PPgrCommParte
{
    private PComm _comm_;
    private PPgrCommParte _pgrCommParte_;

    public AComCommPgrCommParte()
    {
        // Constructor
    }

    public AComCommPgrCommParte(
        @SuppressWarnings("hiding") PComm _comm_,
        @SuppressWarnings("hiding") PPgrCommParte _pgrCommParte_)
    {
        // Constructor
        setComm(_comm_);

        setPgrCommParte(_pgrCommParte_);

    }

    @Override
    public Object clone()
    {
        return new AComCommPgrCommParte(
            cloneNode(this._comm_),
            cloneNode(this._pgrCommParte_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComCommPgrCommParte(this);
    }

    public PComm getComm()
    {
        return this._comm_;
    }

    public void setComm(PComm node)
    {
        if(this._comm_ != null)
        {
            this._comm_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comm_ = node;
    }

    public PPgrCommParte getPgrCommParte()
    {
        return this._pgrCommParte_;
    }

    public void setPgrCommParte(PPgrCommParte node)
    {
        if(this._pgrCommParte_ != null)
        {
            this._pgrCommParte_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pgrCommParte_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comm_)
            + toString(this._pgrCommParte_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comm_ == child)
        {
            this._comm_ = null;
            return;
        }

        if(this._pgrCommParte_ == child)
        {
            this._pgrCommParte_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comm_ == oldChild)
        {
            setComm((PComm) newChild);
            return;
        }

        if(this._pgrCommParte_ == oldChild)
        {
            setPgrCommParte((PPgrCommParte) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}