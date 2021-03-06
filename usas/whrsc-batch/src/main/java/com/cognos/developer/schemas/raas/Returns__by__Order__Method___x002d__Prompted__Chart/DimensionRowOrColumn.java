/**
 * DimensionRowOrColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;


/**
 * A crosstab dimension value.
 */
public class DimensionRowOrColumn  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell name;

    /* The first row/column in the data table to which this row/column
     * value maps. */
    private int start;

    /* The number of rows/columns to which that this row/column value
     * maps. */
    private int size;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn[] nestedDimension;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumnExtension extension;

    public DimensionRowOrColumn() {
    }

    public DimensionRowOrColumn(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell name,
           int start,
           int size,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn[] nestedDimension,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumnExtension extension) {
           this.name = name;
           this.start = start;
           this.size = size;
           this.nestedDimension = nestedDimension;
           this.extension = extension;
    }


    /**
     * Gets the name value for this DimensionRowOrColumn.
     * 
     * @return name
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell getName() {
        return name;
    }


    /**
     * Sets the name value for this DimensionRowOrColumn.
     * 
     * @param name
     */
    public void setName(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell name) {
        this.name = name;
    }


    /**
     * Gets the start value for this DimensionRowOrColumn.
     * 
     * @return start   * The first row/column in the data table to which this row/column
     * value maps.
     */
    public int getStart() {
        return start;
    }


    /**
     * Sets the start value for this DimensionRowOrColumn.
     * 
     * @param start   * The first row/column in the data table to which this row/column
     * value maps.
     */
    public void setStart(int start) {
        this.start = start;
    }


    /**
     * Gets the size value for this DimensionRowOrColumn.
     * 
     * @return size   * The number of rows/columns to which that this row/column value
     * maps.
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this DimensionRowOrColumn.
     * 
     * @param size   * The number of rows/columns to which that this row/column value
     * maps.
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Gets the nestedDimension value for this DimensionRowOrColumn.
     * 
     * @return nestedDimension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn[] getNestedDimension() {
        return nestedDimension;
    }


    /**
     * Sets the nestedDimension value for this DimensionRowOrColumn.
     * 
     * @param nestedDimension
     */
    public void setNestedDimension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn[] nestedDimension) {
        this.nestedDimension = nestedDimension;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn getNestedDimension(int i) {
        return this.nestedDimension[i];
    }

    public void setNestedDimension(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn _value) {
        this.nestedDimension[i] = _value;
    }


    /**
     * Gets the extension value for this DimensionRowOrColumn.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumnExtension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this DimensionRowOrColumn.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumnExtension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DimensionRowOrColumn)) return false;
        DimensionRowOrColumn other = (DimensionRowOrColumn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.start == other.getStart() &&
            this.size == other.getSize() &&
            ((this.nestedDimension==null && other.getNestedDimension()==null) || 
             (this.nestedDimension!=null &&
              java.util.Arrays.equals(this.nestedDimension, other.getNestedDimension()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getStart();
        _hashCode += getSize();
        if (getNestedDimension() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNestedDimension());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNestedDimension(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DimensionRowOrColumn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DimensionRowOrColumn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Cell"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestedDimension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "nestedDimension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DimensionRowOrColumn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">DimensionRowOrColumn>extension"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
