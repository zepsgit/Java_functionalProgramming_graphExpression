/* Generated By:JavaCC: Do not edit this line. ExpParserConstants.java */
package parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ExpParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int PLUS = 5;
  /** RegularExpression Id. */
  int MINUS = 6;
  /** RegularExpression Id. */
  int MULTIPLY = 7;
  /** RegularExpression Id. */
  int DIVIDE = 8;
  /** RegularExpression Id. */
  int LPAR = 9;
  /** RegularExpression Id. */
  int RPAR = 10;
  /** RegularExpression Id. */
  int X = 11;
  /** RegularExpression Id. */
  int SIN = 12;
  /** RegularExpression Id. */
  int COS = 13;
  /** RegularExpression Id. */
  int TAN = 14;
  /** RegularExpression Id. */
  int LN = 15;
  /** RegularExpression Id. */
  int EXP = 16;
  /** RegularExpression Id. */
  int PI = 17;
  /** RegularExpression Id. */
  int E = 18;
  /** RegularExpression Id. */
  int CONSTANT = 19;
  /** RegularExpression Id. */
  int EXPONENT = 20;
  /** RegularExpression Id. */
  int MANTISSA = 21;
  /** RegularExpression Id. */
  int DIGIT = 22;
  /** RegularExpression Id. */
  int UNEXPECTED_CHARACTER = 23;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"(\"",
    "\")\"",
    "\"x\"",
    "\"sin\"",
    "\"cos\"",
    "\"tan\"",
    "\"ln\"",
    "\"exp\"",
    "<PI>",
    "\"e\"",
    "<CONSTANT>",
    "<EXPONENT>",
    "<MANTISSA>",
    "<DIGIT>",
    "<UNEXPECTED_CHARACTER>",
  };

}
