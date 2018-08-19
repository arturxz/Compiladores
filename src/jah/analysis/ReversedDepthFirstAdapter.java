/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.analysis;

import java.util.*;
import jah.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPPgr().apply(this);
        outStart(node);
    }

    public void inASemTudoPgr(ASemTudoPgr node)
    {
        defaultIn(node);
    }

    public void outASemTudoPgr(ASemTudoPgr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASemTudoPgr(ASemTudoPgr node)
    {
        inASemTudoPgr(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outASemTudoPgr(node);
    }

    public void inAComDeclPgr(AComDeclPgr node)
    {
        defaultIn(node);
    }

    public void outAComDeclPgr(AComDeclPgr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComDeclPgr(AComDeclPgr node)
    {
        inAComDeclPgr(node);
        if(node.getDecls() != null)
        {
            node.getDecls().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAComDeclPgr(node);
    }

    public void inAComCommPgr(AComCommPgr node)
    {
        defaultIn(node);
    }

    public void outAComCommPgr(AComCommPgr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComCommPgr(AComCommPgr node)
    {
        inAComCommPgr(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAComCommPgr(node);
    }

    public void inAComTudoPgr(AComTudoPgr node)
    {
        defaultIn(node);
    }

    public void outAComTudoPgr(AComTudoPgr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComTudoPgr(AComTudoPgr node)
    {
        inAComTudoPgr(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getDecls() != null)
        {
            node.getDecls().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAComTudoPgr(node);
    }

    public void inAMultipDecls(AMultipDecls node)
    {
        defaultIn(node);
    }

    public void outAMultipDecls(AMultipDecls node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultipDecls(AMultipDecls node)
    {
        inAMultipDecls(node);
        if(node.getDecls() != null)
        {
            node.getDecls().apply(this);
        }
        if(node.getDecl() != null)
        {
            node.getDecl().apply(this);
        }
        outAMultipDecls(node);
    }

    public void inASingleDecls(ASingleDecls node)
    {
        defaultIn(node);
    }

    public void outASingleDecls(ASingleDecls node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASingleDecls(ASingleDecls node)
    {
        inASingleDecls(node);
        if(node.getDecl() != null)
        {
            node.getDecl().apply(this);
        }
        outASingleDecls(node);
    }

    public void inAVariaveisDecl(AVariaveisDecl node)
    {
        defaultIn(node);
    }

    public void outAVariaveisDecl(AVariaveisDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVariaveisDecl(AVariaveisDecl node)
    {
        inAVariaveisDecl(node);
        if(node.getVarList() != null)
        {
            node.getVarList().apply(this);
        }
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        outAVariaveisDecl(node);
    }

    public void inAConstanteDecl(AConstanteDecl node)
    {
        defaultIn(node);
    }

    public void outAConstanteDecl(AConstanteDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConstanteDecl(AConstanteDecl node)
    {
        inAConstanteDecl(node);
        if(node.getValor() != null)
        {
            node.getValor().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAConstanteDecl(node);
    }

    public void inAMultipVarList(AMultipVarList node)
    {
        defaultIn(node);
    }

    public void outAMultipVarList(AMultipVarList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultipVarList(AMultipVarList node)
    {
        inAMultipVarList(node);
        if(node.getVarList() != null)
        {
            node.getVarList().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAMultipVarList(node);
    }

    public void inASingleVarList(ASingleVarList node)
    {
        defaultIn(node);
    }

    public void outASingleVarList(ASingleVarList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASingleVarList(ASingleVarList node)
    {
        inASingleVarList(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outASingleVarList(node);
    }

    public void inANormalVar(ANormalVar node)
    {
        defaultIn(node);
    }

    public void outANormalVar(ANormalVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANormalVar(ANormalVar node)
    {
        inANormalVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outANormalVar(node);
    }

    public void inAArrayVar(AArrayVar node)
    {
        defaultIn(node);
    }

    public void outAArrayVar(AArrayVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayVar(AArrayVar node)
    {
        inAArrayVar(node);
        if(node.getInteiro() != null)
        {
            node.getInteiro().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAArrayVar(node);
    }

    public void inARealTipo(ARealTipo node)
    {
        defaultIn(node);
    }

    public void outARealTipo(ARealTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARealTipo(ARealTipo node)
    {
        inARealTipo(node);
        if(node.getTipoReal() != null)
        {
            node.getTipoReal().apply(this);
        }
        outARealTipo(node);
    }

    public void inAInteiroTipo(AInteiroTipo node)
    {
        defaultIn(node);
    }

    public void outAInteiroTipo(AInteiroTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInteiroTipo(AInteiroTipo node)
    {
        inAInteiroTipo(node);
        if(node.getTipoInteiro() != null)
        {
            node.getTipoInteiro().apply(this);
        }
        outAInteiroTipo(node);
    }

    public void inAStringTipo(AStringTipo node)
    {
        defaultIn(node);
    }

    public void outAStringTipo(AStringTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringTipo(AStringTipo node)
    {
        inAStringTipo(node);
        if(node.getTipoString() != null)
        {
            node.getTipoString().apply(this);
        }
        outAStringTipo(node);
    }

    public void inAStringValor(AStringValor node)
    {
        defaultIn(node);
    }

    public void outAStringValor(AStringValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringValor(AStringValor node)
    {
        inAStringValor(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStringValor(node);
    }

    public void inAInteiroValor(AInteiroValor node)
    {
        defaultIn(node);
    }

    public void outAInteiroValor(AInteiroValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInteiroValor(AInteiroValor node)
    {
        inAInteiroValor(node);
        if(node.getInteiro() != null)
        {
            node.getInteiro().apply(this);
        }
        outAInteiroValor(node);
    }

    public void inARealValor(ARealValor node)
    {
        defaultIn(node);
    }

    public void outARealValor(ARealValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARealValor(ARealValor node)
    {
        inARealValor(node);
        if(node.getReal() != null)
        {
            node.getReal().apply(this);
        }
        outARealValor(node);
    }

    public void inAMultipComms(AMultipComms node)
    {
        defaultIn(node);
    }

    public void outAMultipComms(AMultipComms node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultipComms(AMultipComms node)
    {
        inAMultipComms(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getComm() != null)
        {
            node.getComm().apply(this);
        }
        outAMultipComms(node);
    }

    public void inASingleComms(ASingleComms node)
    {
        defaultIn(node);
    }

    public void outASingleComms(ASingleComms node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASingleComms(ASingleComms node)
    {
        inASingleComms(node);
        if(node.getComm() != null)
        {
            node.getComm().apply(this);
        }
        outASingleComms(node);
    }

    public void inASimplesComm(ASimplesComm node)
    {
        defaultIn(node);
    }

    public void outASimplesComm(ASimplesComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASimplesComm(ASimplesComm node)
    {
        inASimplesComm(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outASimplesComm(node);
    }

    public void inALeiaComm(ALeiaComm node)
    {
        defaultIn(node);
    }

    public void outALeiaComm(ALeiaComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALeiaComm(ALeiaComm node)
    {
        inALeiaComm(node);
        if(node.getCommLeia() != null)
        {
            node.getCommLeia().apply(this);
        }
        outALeiaComm(node);
    }

    public void inAEscrevaComm(AEscrevaComm node)
    {
        defaultIn(node);
    }

    public void outAEscrevaComm(AEscrevaComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEscrevaComm(AEscrevaComm node)
    {
        inAEscrevaComm(node);
        if(node.getCommEscreva() != null)
        {
            node.getCommEscreva().apply(this);
        }
        outAEscrevaComm(node);
    }

    public void inASeComm(ASeComm node)
    {
        defaultIn(node);
    }

    public void outASeComm(ASeComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASeComm(ASeComm node)
    {
        inASeComm(node);
        if(node.getCommSe() != null)
        {
            node.getCommSe().apply(this);
        }
        outASeComm(node);
    }

    public void inAAvalieComm(AAvalieComm node)
    {
        defaultIn(node);
    }

    public void outAAvalieComm(AAvalieComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAvalieComm(AAvalieComm node)
    {
        inAAvalieComm(node);
        if(node.getCommAvalie() != null)
        {
            node.getCommAvalie().apply(this);
        }
        outAAvalieComm(node);
    }

    public void inAEnquantoComm(AEnquantoComm node)
    {
        defaultIn(node);
    }

    public void outAEnquantoComm(AEnquantoComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEnquantoComm(AEnquantoComm node)
    {
        inAEnquantoComm(node);
        if(node.getCommEnquanto() != null)
        {
            node.getCommEnquanto().apply(this);
        }
        outAEnquantoComm(node);
    }

    public void inARepitaComm(ARepitaComm node)
    {
        defaultIn(node);
    }

    public void outARepitaComm(ARepitaComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARepitaComm(ARepitaComm node)
    {
        inARepitaComm(node);
        if(node.getCommRepita() != null)
        {
            node.getCommRepita().apply(this);
        }
        outARepitaComm(node);
    }

    public void inAParaComm(AParaComm node)
    {
        defaultIn(node);
    }

    public void outAParaComm(AParaComm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParaComm(AParaComm node)
    {
        inAParaComm(node);
        if(node.getCommPara() != null)
        {
            node.getCommPara().apply(this);
        }
        outAParaComm(node);
    }

    public void inAAlgoCommLeia(AAlgoCommLeia node)
    {
        defaultIn(node);
    }

    public void outAAlgoCommLeia(AAlgoCommLeia node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAlgoCommLeia(AAlgoCommLeia node)
    {
        inAAlgoCommLeia(node);
        if(node.getCommLeia() != null)
        {
            node.getCommLeia().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAAlgoCommLeia(node);
    }

    public void inANadaCommLeia(ANadaCommLeia node)
    {
        defaultIn(node);
    }

    public void outANadaCommLeia(ANadaCommLeia node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANadaCommLeia(ANadaCommLeia node)
    {
        inANadaCommLeia(node);
        outANadaCommLeia(node);
    }

    public void inAAlgoExpAriCommEscreva(AAlgoExpAriCommEscreva node)
    {
        defaultIn(node);
    }

    public void outAAlgoExpAriCommEscreva(AAlgoExpAriCommEscreva node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAlgoExpAriCommEscreva(AAlgoExpAriCommEscreva node)
    {
        inAAlgoExpAriCommEscreva(node);
        if(node.getCommEscreva() != null)
        {
            node.getCommEscreva().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAAlgoExpAriCommEscreva(node);
    }

    public void inAAlgoExpLogCommEscreva(AAlgoExpLogCommEscreva node)
    {
        defaultIn(node);
    }

    public void outAAlgoExpLogCommEscreva(AAlgoExpLogCommEscreva node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAlgoExpLogCommEscreva(AAlgoExpLogCommEscreva node)
    {
        inAAlgoExpLogCommEscreva(node);
        if(node.getCommEscreva() != null)
        {
            node.getCommEscreva().apply(this);
        }
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outAAlgoExpLogCommEscreva(node);
    }

    public void inANadaCommEscreva(ANadaCommEscreva node)
    {
        defaultIn(node);
    }

    public void outANadaCommEscreva(ANadaCommEscreva node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANadaCommEscreva(ANadaCommEscreva node)
    {
        inANadaCommEscreva(node);
        outANadaCommEscreva(node);
    }

    public void inAComSenaoCommSe(AComSenaoCommSe node)
    {
        defaultIn(node);
    }

    public void outAComSenaoCommSe(AComSenaoCommSe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComSenaoCommSe(AComSenaoCommSe node)
    {
        inAComSenaoCommSe(node);
        if(node.getCommSeSenao() != null)
        {
            node.getCommSeSenao().apply(this);
        }
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outAComSenaoCommSe(node);
    }

    public void inASemSenaoCommSe(ASemSenaoCommSe node)
    {
        defaultIn(node);
    }

    public void outASemSenaoCommSe(ASemSenaoCommSe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASemSenaoCommSe(ASemSenaoCommSe node)
    {
        inASemSenaoCommSe(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outASemSenaoCommSe(node);
    }

    public void inACommSeSenao(ACommSeSenao node)
    {
        defaultIn(node);
    }

    public void outACommSeSenao(ACommSeSenao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommSeSenao(ACommSeSenao node)
    {
        inACommSeSenao(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        outACommSeSenao(node);
    }

    public void inAExpAriCommAvalie(AExpAriCommAvalie node)
    {
        defaultIn(node);
    }

    public void outAExpAriCommAvalie(AExpAriCommAvalie node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpAriCommAvalie(AExpAriCommAvalie node)
    {
        inAExpAriCommAvalie(node);
        if(node.getCommAvalieCasoParte() != null)
        {
            node.getCommAvalieCasoParte().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAExpAriCommAvalie(node);
    }

    public void inAExpLogCommAvalie(AExpLogCommAvalie node)
    {
        defaultIn(node);
    }

    public void outAExpLogCommAvalie(AExpLogCommAvalie node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpLogCommAvalie(AExpLogCommAvalie node)
    {
        inAExpLogCommAvalie(node);
        if(node.getCommAvalieCasoParte() != null)
        {
            node.getCommAvalieCasoParte().apply(this);
        }
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outAExpLogCommAvalie(node);
    }

    public void inAComCasoCommAvalieCasoParte(AComCasoCommAvalieCasoParte node)
    {
        defaultIn(node);
    }

    public void outAComCasoCommAvalieCasoParte(AComCasoCommAvalieCasoParte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComCasoCommAvalieCasoParte(AComCasoCommAvalieCasoParte node)
    {
        inAComCasoCommAvalieCasoParte(node);
        if(node.getCommAvalieCasoParte() != null)
        {
            node.getCommAvalieCasoParte().apply(this);
        }
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getValor() != null)
        {
            node.getValor().apply(this);
        }
        outAComCasoCommAvalieCasoParte(node);
    }

    public void inASemCasoCommAvalieCasoParte(ASemCasoCommAvalieCasoParte node)
    {
        defaultIn(node);
    }

    public void outASemCasoCommAvalieCasoParte(ASemCasoCommAvalieCasoParte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASemCasoCommAvalieCasoParte(ASemCasoCommAvalieCasoParte node)
    {
        inASemCasoCommAvalieCasoParte(node);
        if(node.getCommAvalieSenaoParte() != null)
        {
            node.getCommAvalieSenaoParte().apply(this);
        }
        outASemCasoCommAvalieCasoParte(node);
    }

    public void inAComSenaoCommAvalieSenaoParte(AComSenaoCommAvalieSenaoParte node)
    {
        defaultIn(node);
    }

    public void outAComSenaoCommAvalieSenaoParte(AComSenaoCommAvalieSenaoParte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComSenaoCommAvalieSenaoParte(AComSenaoCommAvalieSenaoParte node)
    {
        inAComSenaoCommAvalieSenaoParte(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        outAComSenaoCommAvalieSenaoParte(node);
    }

    public void inASemSenaoCommAvalieSenaoParte(ASemSenaoCommAvalieSenaoParte node)
    {
        defaultIn(node);
    }

    public void outASemSenaoCommAvalieSenaoParte(ASemSenaoCommAvalieSenaoParte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASemSenaoCommAvalieSenaoParte(ASemSenaoCommAvalieSenaoParte node)
    {
        inASemSenaoCommAvalieSenaoParte(node);
        outASemSenaoCommAvalieSenaoParte(node);
    }

    public void inACommEnquanto(ACommEnquanto node)
    {
        defaultIn(node);
    }

    public void outACommEnquanto(ACommEnquanto node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommEnquanto(ACommEnquanto node)
    {
        inACommEnquanto(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outACommEnquanto(node);
    }

    public void inACommEnquantoFim(ACommEnquantoFim node)
    {
        defaultIn(node);
    }

    public void outACommEnquantoFim(ACommEnquantoFim node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommEnquantoFim(ACommEnquantoFim node)
    {
        inACommEnquantoFim(node);
        outACommEnquantoFim(node);
    }

    public void inACommRepita(ACommRepita node)
    {
        defaultIn(node);
    }

    public void outACommRepita(ACommRepita node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommRepita(ACommRepita node)
    {
        inACommRepita(node);
        if(node.getCommRepitaCommsParte() != null)
        {
            node.getCommRepitaCommsParte().apply(this);
        }
        outACommRepita(node);
    }

    public void inACommRepitaCommsParte(ACommRepitaCommsParte node)
    {
        defaultIn(node);
    }

    public void outACommRepitaCommsParte(ACommRepitaCommsParte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommRepitaCommsParte(ACommRepitaCommsParte node)
    {
        inACommRepitaCommsParte(node);
        if(node.getCommRepitaCondicaoParte() != null)
        {
            node.getCommRepitaCondicaoParte().apply(this);
        }
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        outACommRepitaCommsParte(node);
    }

    public void inACommRepitaCondicaoParte(ACommRepitaCondicaoParte node)
    {
        defaultIn(node);
    }

    public void outACommRepitaCondicaoParte(ACommRepitaCondicaoParte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommRepitaCondicaoParte(ACommRepitaCondicaoParte node)
    {
        inACommRepitaCondicaoParte(node);
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outACommRepitaCondicaoParte(node);
    }

    public void inACommPara(ACommPara node)
    {
        defaultIn(node);
    }

    public void outACommPara(ACommPara node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommPara(ACommPara node)
    {
        inACommPara(node);
        if(node.getCommParaPassa() != null)
        {
            node.getCommParaPassa().apply(this);
        }
        if(node.getInteiro() != null)
        {
            node.getInteiro().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outACommPara(node);
    }

    public void inAComPassoCommParaPassa(AComPassoCommParaPassa node)
    {
        defaultIn(node);
    }

    public void outAComPassoCommParaPassa(AComPassoCommParaPassa node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComPassoCommParaPassa(AComPassoCommParaPassa node)
    {
        inAComPassoCommParaPassa(node);
        if(node.getCommParaAte() != null)
        {
            node.getCommParaAte().apply(this);
        }
        if(node.getInteiro() != null)
        {
            node.getInteiro().apply(this);
        }
        outAComPassoCommParaPassa(node);
    }

    public void inASemPassoCommParaPassa(ASemPassoCommParaPassa node)
    {
        defaultIn(node);
    }

    public void outASemPassoCommParaPassa(ASemPassoCommParaPassa node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASemPassoCommParaPassa(ASemPassoCommParaPassa node)
    {
        inASemPassoCommParaPassa(node);
        if(node.getCommParaAte() != null)
        {
            node.getCommParaAte().apply(this);
        }
        outASemPassoCommParaPassa(node);
    }

    public void inACommParaAte(ACommParaAte node)
    {
        defaultIn(node);
    }

    public void outACommParaAte(ACommParaAte node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommParaAte(ACommParaAte node)
    {
        inACommParaAte(node);
        if(node.getCommParaFim() != null)
        {
            node.getCommParaFim().apply(this);
        }
        if(node.getInteiro() != null)
        {
            node.getInteiro().apply(this);
        }
        outACommParaAte(node);
    }

    public void inAFimCommParaFim(AFimCommParaFim node)
    {
        defaultIn(node);
    }

    public void outAFimCommParaFim(AFimCommParaFim node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFimCommParaFim(AFimCommParaFim node)
    {
        inAFimCommParaFim(node);
        if(node.getComms() != null)
        {
            node.getComms().apply(this);
        }
        outAFimCommParaFim(node);
    }

    public void inANadaCommParaFim(ANadaCommParaFim node)
    {
        defaultIn(node);
    }

    public void outANadaCommParaFim(ANadaCommParaFim node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANadaCommParaFim(ANadaCommParaFim node)
    {
        inANadaCommParaFim(node);
        outANadaCommParaFim(node);
    }

    public void inASomaExp(ASomaExp node)
    {
        defaultIn(node);
    }

    public void outASomaExp(ASomaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node)
    {
        inASomaExp(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outASomaExp(node);
    }

    public void inASubtExp(ASubtExp node)
    {
        defaultIn(node);
    }

    public void outASubtExp(ASubtExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubtExp(ASubtExp node)
    {
        inASubtExp(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outASubtExp(node);
    }

    public void inAMultExp(AMultExp node)
    {
        defaultIn(node);
    }

    public void outAMultExp(AMultExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultExp(AMultExp node)
    {
        inAMultExp(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAMultExp(node);
    }

    public void inADiviExp(ADiviExp node)
    {
        defaultIn(node);
    }

    public void outADiviExp(ADiviExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADiviExp(ADiviExp node)
    {
        inADiviExp(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outADiviExp(node);
    }

    public void inANegaExp(ANegaExp node)
    {
        defaultIn(node);
    }

    public void outANegaExp(ANegaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegaExp(ANegaExp node)
    {
        inANegaExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANegaExp(node);
    }

    public void inAVarExp(AVarExp node)
    {
        defaultIn(node);
    }

    public void outAVarExp(AVarExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarExp(AVarExp node)
    {
        inAVarExp(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarExp(node);
    }

    public void inAValExp(AValExp node)
    {
        defaultIn(node);
    }

    public void outAValExp(AValExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValExp(AValExp node)
    {
        inAValExp(node);
        if(node.getValor() != null)
        {
            node.getValor().apply(this);
        }
        outAValExp(node);
    }

    public void inANotExpLogica(ANotExpLogica node)
    {
        defaultIn(node);
    }

    public void outANotExpLogica(ANotExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExpLogica(ANotExpLogica node)
    {
        inANotExpLogica(node);
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outANotExpLogica(node);
    }

    public void inAOuExpLogica(AOuExpLogica node)
    {
        defaultIn(node);
    }

    public void outAOuExpLogica(AOuExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExpLogica(AOuExpLogica node)
    {
        inAOuExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAOuExpLogica(node);
    }

    public void inAAndExpLogica(AAndExpLogica node)
    {
        defaultIn(node);
    }

    public void outAAndExpLogica(AAndExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndExpLogica(AAndExpLogica node)
    {
        inAAndExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAAndExpLogica(node);
    }

    public void inAXorExpLogica(AXorExpLogica node)
    {
        defaultIn(node);
    }

    public void outAXorExpLogica(AXorExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAXorExpLogica(AXorExpLogica node)
    {
        inAXorExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAXorExpLogica(node);
    }

    public void inADiferenteExpLogica(ADiferenteExpLogica node)
    {
        defaultIn(node);
    }

    public void outADiferenteExpLogica(ADiferenteExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADiferenteExpLogica(ADiferenteExpLogica node)
    {
        inADiferenteExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outADiferenteExpLogica(node);
    }

    public void inAMaiorqExpLogica(AMaiorqExpLogica node)
    {
        defaultIn(node);
    }

    public void outAMaiorqExpLogica(AMaiorqExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorqExpLogica(AMaiorqExpLogica node)
    {
        inAMaiorqExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAMaiorqExpLogica(node);
    }

    public void inAMenorqExpLogica(AMenorqExpLogica node)
    {
        defaultIn(node);
    }

    public void outAMenorqExpLogica(AMenorqExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorqExpLogica(AMenorqExpLogica node)
    {
        inAMenorqExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAMenorqExpLogica(node);
    }

    public void inAIgualExpLogica(AIgualExpLogica node)
    {
        defaultIn(node);
    }

    public void outAIgualExpLogica(AIgualExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIgualExpLogica(AIgualExpLogica node)
    {
        inAIgualExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAIgualExpLogica(node);
    }

    public void inAMaiorExpLogica(AMaiorExpLogica node)
    {
        defaultIn(node);
    }

    public void outAMaiorExpLogica(AMaiorExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorExpLogica(AMaiorExpLogica node)
    {
        inAMaiorExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAMaiorExpLogica(node);
    }

    public void inAMenorExpLogica(AMenorExpLogica node)
    {
        defaultIn(node);
    }

    public void outAMenorExpLogica(AMenorExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorExpLogica(AMenorExpLogica node)
    {
        inAMenorExpLogica(node);
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        outAMenorExpLogica(node);
    }
}
