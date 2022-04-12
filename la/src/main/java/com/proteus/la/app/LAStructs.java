package com.proteus.la.app;

import com.proteus.la.*;
import java.util.Map;
import java.util.LinkedHashMap;


public class LAStructs {

  static public class Chain{
    public Chain(){
      groups = new LinkedHashMap<String, Group>();
    }
    public String name;
    public Chain_definitionContextExt chainContextExt;
    public Map<String, Group> groups;
  }

  static public class Group{
    public Group(){
      elements = new LinkedHashMap<String, Element>();
    }
    public String name;
    public Group_definitionContextExt groupContextExt;
    public Map<String, Element> elements;
  }

  static public class Element{
    public Element(){
      fields = new LinkedHashMap<String, Field>();
    }
    public String name;
    public ElementContextExt elementContextExt;
    public Map<String, Field> fields;
  }

  static public class Field{
    public String name;
    public FieldContextExt fieldContextExt;
  }
  static public Map<String, Chain> chains;

}
