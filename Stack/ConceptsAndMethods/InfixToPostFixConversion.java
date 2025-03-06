package Stack.ConceptsAndMethods;

import java.util.Stack;

public class InfixToPostFixConversion {

        public static void main(String[] args) {
            String infix = "9-(5+3)*4/6";
            System.out.println("Infix:  " + infix);
            Stack<String> oprnds = new Stack<>();  // operands
            Stack<Character> oprtor = new Stack<>(); // operator

            for (int i=0; i<infix.length(); i++){
                char ch = infix.charAt(i);
                int ascii = (int)ch;

                if (ascii>=48 && ascii<=57)   {
                    String s = "" + ch;
                    oprnds.push(s);
                }

                else if (oprtor.isEmpty() || ch=='(' || oprtor.peek()=='(') {
                    oprtor.push(ch);

                } else if (ch==')') {
                    while (oprtor.peek()!='('){
                        // work
                        String v2 = oprnds.pop();
                        String v1 = oprnds.pop();
                        char opr = oprtor.pop();
                        String val = v1 + v2 + opr;
                        oprnds.push(val);
                        //push
//                        oprtor.push(ch);

                    }
                    oprtor.pop(); // '(' hta dia
                }
                else {
                    if (ch=='+' || ch=='-'){
                        // work
                        String v2 = oprnds.pop();
                        String v1 = oprnds.pop();
                        char opr = oprtor.pop();
                        String val = v1 + v2 + opr;
                        oprnds.push(val);
                        //push
                        oprtor.push(ch);

                    }
                    if (ch=='*' || ch=='/'){  // same as lower proirity characters

                        if (oprtor.peek()=='*' || oprtor.peek()=='/'){
                            // work
                            String v2 = oprnds.pop();
                            String v1 = oprnds.pop();
                            char opr = oprtor.pop();
                            String val = v1 + v2 + opr;
                            oprnds.push(val);
                            //push
                            oprtor.push(ch);
                        }
                        else oprtor.push(ch);
                    }


                }
            }
            while (oprnds.size()>1){
                String v2 = oprnds.pop();
                String v1 = oprnds.pop();
                char opr = oprtor.pop();
                String val = v1 + v2 + opr;
                oprnds.push(val);

            }
            String Postfix = oprnds.peek();
            System.out.println("Postfix: " +  Postfix);

        }
    }




