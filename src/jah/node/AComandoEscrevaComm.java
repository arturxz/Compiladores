/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AComandoEscrevaComm extends PComm
{
    private TEscreva _escreva_;
    private TAbreParentesis _abreParentesis_;
    private PPosExpComm _posExpComm_;
    private TFechaParentesis _fechaParentesis_;
    private TPontoVirgula _pontoVirgula_;

    public AComandoEscrevaComm()
    {
        // Constructor
    }

    public AComandoEscrevaComm(
        @SuppressWarnings("hiding") TEscreva _escreva_,
        @SuppressWarnings("hiding") TAbreParentesis _abreParentesis_,
        @SuppressWarnings("hiding") PPosExpComm _posExpComm_,
        @SuppressWarnings("hiding") TFechaParentesis _fechaParentesis_,
        @SuppressWarnings("hiding") TPontoVirgula _pontoVirgula_)
    {
        // Constructor
        setEscreva(_escreva_);

        setAbreParentesis(_abreParentesis_);

        setPosExpComm(_posExpComm_);

        setFechaParentesis(_fechaParentesis_);

        setPontoVirgula(_pontoVirgula_);

    }

    @Override
    public Object clone()
    {
        return new AComandoEscrevaComm(
            cloneNode(this._escreva_),
            cloneNode(this._abreParentesis_),
            cloneNode(this._posExpComm_),
            cloneNode(this._fechaParentesis_),
            cloneNode(this._pontoVirgula_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComandoEscrevaComm(this);
    }

    public TEscreva getEscreva()
    {
        return this._escreva_;
    }

    public void setEscreva(TEscreva node)
    {
        if(this._escreva_ != null)
        {
            this._escreva_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._escreva_ = node;
    }

    public TAbreParentesis getAbreParentesis()
    {
        return this._abreParentesis_;
    }

    public void setAbreParentesis(TAbreParentesis node)
    {
        if(this._abreParentesis_ != null)
        {
            this._abreParentesis_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._abreParentesis_ = node;
    }

    public PPosExpComm getPosExpComm()
    {
        return this._posExpComm_;
    }

    public void setPosExpComm(PPosExpComm node)
    {
        if(this._posExpComm_ != null)
        {
            this._posExpComm_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._posExpComm_ = node;
    }

    public TFechaParentesis getFechaParentesis()
    {
        return this._fechaParentesis_;
    }

    public void setFechaParentesis(TFechaParentesis node)
    {
        if(this._fechaParentesis_ != null)
        {
            this._fechaParentesis_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fechaParentesis_ = node;
    }

    public TPontoVirgula getPontoVirgula()
    {
        return this._pontoVirgula_;
    }

    public void setPontoVirgula(TPontoVirgula node)
    {
        if(this._pontoVirgula_ != null)
        {
            this._pontoVirgula_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pontoVirgula_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._escreva_)
            + toString(this._abreParentesis_)
            + toString(this._posExpComm_)
            + toString(this._fechaParentesis_)
            + toString(this._pontoVirgula_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._escreva_ == child)
        {
            this._escreva_ = null;
            return;
        }

        if(this._abreParentesis_ == child)
        {
            this._abreParentesis_ = null;
            return;
        }

        if(this._posExpComm_ == child)
        {
            this._posExpComm_ = null;
            return;
        }

        if(this._fechaParentesis_ == child)
        {
            this._fechaParentesis_ = null;
            return;
        }

        if(this._pontoVirgula_ == child)
        {
            this._pontoVirgula_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._escreva_ == oldChild)
        {
            setEscreva((TEscreva) newChild);
            return;
        }

        if(this._abreParentesis_ == oldChild)
        {
            setAbreParentesis((TAbreParentesis) newChild);
            return;
        }

        if(this._posExpComm_ == oldChild)
        {
            setPosExpComm((PPosExpComm) newChild);
            return;
        }

        if(this._fechaParentesis_ == oldChild)
        {
            setFechaParentesis((TFechaParentesis) newChild);
            return;
        }

        if(this._pontoVirgula_ == oldChild)
        {
            setPontoVirgula((TPontoVirgula) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
