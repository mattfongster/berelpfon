/* PatinaParser.java */
/* Generated By:JavaCC: Do not edit this line. PatinaParser.java */
package parser;

import ast.Assignment;
import ast.Declaration;
import ast.Bool;
import ast.Flt;
import ast.IExpression;
import ast.Identifier;
import ast.Int;
import ast.Mult;
import ast.TypeCheckable;
import java.util.LinkedList;

public class PatinaParser implements PatinaParserConstants {

/* Top-level production */
  static final public LinkedList<TypeCheckable> Input() throws ParseException {TypeCheckable a, d;
    IExpression e;
    LinkedList<TypeCheckable> result = new LinkedList<TypeCheckable>();
    label_1:
    while (true) {
      if (jj_2_1(5)) {
        d = Declaration();
        jj_consume_token(PERIOD);
result.add(d);
      } else if (jj_2_2(3)) {
        a = Assignment();
        jj_consume_token(PERIOD);
result.add(a);
      } else if (jj_2_3(3)) {
        e = Expression();
        jj_consume_token(PERIOD);
result.add(e);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case FALSE:
      case LET:
      case TRUE:
      case IDENTIFIER:
      case INTEGER_LITERAL:
      case FLOATING_LITERAL:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
{if ("" != null) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public TypeCheckable Declaration() throws ParseException {TypeCheckable id, md;
    if (jj_2_4(5)) {
      id = ImmutableDeclaration();
{if ("" != null) return id;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LET:{
        md = MutableDeclaration();
{if ("" != null) return md;}
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public TypeCheckable ImmutableDeclaration() throws ParseException {Token t;
    IExpression e;
    t = jj_consume_token(LET);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(BE);
    Type();
    jj_consume_token(LARROW);
    e = Expression();
{if ("" != null) return new Assignment(new Identifier(t.image), e);}
    throw new Error("Missing return statement in function");
  }

  static final public TypeCheckable MutableDeclaration() throws ParseException {Token t;
    t = jj_consume_token(LET);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(BE);
    Type();
    jj_consume_token(MUT);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LARROW:{
      jj_consume_token(LARROW);
      Expression();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      ;
    }
{if ("" != null) return new Declaration(t.image);}
    throw new Error("Missing return statement in function");
  }

/*void FunctionDeclaration() :
{}
{
    <LET> <IDENTIFIER>
}*/
  static final public 
IExpression Expression() throws ParseException {IExpression result, b;
    result = UnaryExpression();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:
      case MULT:
      case DIV:
      case MOD:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        break;
        }
      case MULT:{
        jj_consume_token(MULT);
        break;
        }
      case DIV:{
        jj_consume_token(DIV);
        break;
        }
      case MOD:{
        jj_consume_token(MOD);
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      b = UnaryExpression();
result = new Mult(result, b);
    }
{if ("" != null) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public IExpression UnaryExpression() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INTEGER_LITERAL:{
      t = jj_consume_token(INTEGER_LITERAL);
{if ("" != null) return new Int(Integer.parseInt(t.image));}
      break;
      }
    case FLOATING_LITERAL:{
      t = jj_consume_token(FLOATING_LITERAL);
{if ("" != null) return new Flt(Float.parseFloat(t.image));}
      break;
      }
    case IDENTIFIER:{
      t = jj_consume_token(IDENTIFIER);
{if ("" != null) return new Identifier(t.image);}
      break;
      }
    case TRUE:{
      jj_consume_token(TRUE);
{if ("" != null) return new Bool(true);}
      break;
      }
    case FALSE:{
      jj_consume_token(FALSE);
{if ("" != null) return new Bool(false);}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Type() throws ParseException {
    jj_consume_token(IDENTIFIER);
  }

  static final public Assignment Assignment() throws ParseException {Token t;
    IExpression rhs;
    t = jj_consume_token(IDENTIFIER);
    jj_consume_token(LARROW);
    rhs = Expression();
{if ("" != null) return new Assignment(new Identifier(t.image), rhs);}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_3R_6()
 {
    if (jj_scan_token(LET)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(BE)) return true;
    if (jj_scan_token(41)) return true;
    if (jj_scan_token(LARROW)) return true;
    return false;
  }

  static private boolean jj_3R_15()
 {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  static private boolean jj_3R_14()
 {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  static private boolean jj_3R_13()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3R_7()
 {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_12()
 {
    if (jj_scan_token(FLOATING_LITERAL)) return true;
    return false;
  }

  static private boolean jj_3R_8()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_11()
 {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  static private boolean jj_3_4()
 {
    if (jj_3R_6()) return true;
    return false;
  }

  static private boolean jj_3R_3()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3R_7()) return true;
    }
    return false;
  }

  static private boolean jj_3_3()
 {
    if (jj_3R_5()) return true;
    if (jj_scan_token(PERIOD)) return true;
    return false;
  }

  static private boolean jj_3R_9()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(26)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_scan_token(28)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(30)) return true;
    }
    }
    }
    }
    if (jj_3R_8()) return true;
    return false;
  }

  static private boolean jj_3_2()
 {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3_1()
 {
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3R_5()
 {
    if (jj_3R_8()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_9()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3R_4()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(LARROW)) return true;
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3R_10()
 {
    if (jj_scan_token(LET)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(BE)) return true;
    if (jj_scan_token(41)) return true;
    if (jj_scan_token(MUT)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public PatinaParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x890,0x80,0x2000,0x7c000000,0x7c000000,0x810,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x3200,0x0,0x0,0x0,0x0,0x3200,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[4];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public PatinaParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public PatinaParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new PatinaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public PatinaParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new PatinaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public PatinaParser(PatinaParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(PatinaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[46];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 46; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
