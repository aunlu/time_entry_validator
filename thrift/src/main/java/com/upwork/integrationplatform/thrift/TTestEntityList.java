/**
 * REQUIRED TO TEST ARCHETYPE
 * TODO: DELETE AFTER PROJECT GENERATION
 */
package com.upwork.integrationplatform.thrift;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TTestEntityList implements org.apache.thrift.TBase<TTestEntityList, TTestEntityList._Fields>, java.io.Serializable, Cloneable {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTestEntityList");

    private static final org.apache.thrift.protocol.TField TEST_ENTITYS_FIELD_DESC = new org.apache.thrift.protocol.TField("TestEntitys", org.apache.thrift.protocol.TType.LIST, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
        schemes.put(StandardScheme.class, new TTestEntityListStandardSchemeFactory());
        schemes.put(TupleScheme.class, new TTestEntityListTupleSchemeFactory());
    }

    private List<TTestEntity> TestEntitys; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        TEST_ENTITYS((short)1, "TestEntitys");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static {
            for (_Fields field : EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch(fieldId) {
                case 1: // TEST_ENTITYS
                    return TEST_ENTITYS;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByName(String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
        Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.TEST_ENTITYS, new org.apache.thrift.meta_data.FieldMetaData("TestEntitys", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST,
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TTestEntity.class))));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTestEntityList.class, metaDataMap);
    }

    public TTestEntityList() {
    }

    public TTestEntityList(
            List<TTestEntity> TestEntitys)
    {
        this();
        this.TestEntitys = TestEntitys;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public TTestEntityList(TTestEntityList other) {
        if (other.isSetTestEntitys()) {
            List<TTestEntity> __this__TestEntitys = new ArrayList<TTestEntity>();
            for (TTestEntity other_element : other.TestEntitys) {
                __this__TestEntitys.add(new TTestEntity(other_element));
            }
            this.TestEntitys = __this__TestEntitys;
        }
    }

    public TTestEntityList deepCopy() {
        return new TTestEntityList(this);
    }

    @Override
    public void clear() {
        this.TestEntitys = null;
    }

    public int getTestEntitysSize() {
        return (this.TestEntitys == null) ? 0 : this.TestEntitys.size();
    }

    public java.util.Iterator<TTestEntity> getTestEntitysIterator() {
        return (this.TestEntitys == null) ? null : this.TestEntitys.iterator();
    }

    public void addToTestEntitys(TTestEntity elem) {
        if (this.TestEntitys == null) {
            this.TestEntitys = new ArrayList<TTestEntity>();
        }
        this.TestEntitys.add(elem);
    }

    public List<TTestEntity> getTestEntitys() {
        return this.TestEntitys;
    }

    public void setTestEntitys(List<TTestEntity> TestEntitys) {
        this.TestEntitys = TestEntitys;
    }

    public void unsetTestEntitys() {
        this.TestEntitys = null;
    }

    /** Returns true if field TestEntitys is set (has been assigned a value) and false otherwise */
    public boolean isSetTestEntitys() {
        return this.TestEntitys != null;
    }

    public void setTestEntitysIsSet(boolean value) {
        if (!value) {
            this.TestEntitys = null;
        }
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case TEST_ENTITYS:
                if (value == null) {
                    unsetTestEntitys();
                } else {
                    setTestEntitys((List<TTestEntity>)value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case TEST_ENTITYS:
                return getTestEntitys();

        }
        throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        switch (field) {
            case TEST_ENTITYS:
                return isSetTestEntitys();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof TTestEntityList)
            return this.equals((TTestEntityList)that);
        return false;
    }

    public boolean equals(TTestEntityList that) {
        if (that == null)
            return false;

        boolean this_present_TestEntitys = true && this.isSetTestEntitys();
        boolean that_present_TestEntitys = true && that.isSetTestEntitys();
        if (this_present_TestEntitys || that_present_TestEntitys) {
            if (!(this_present_TestEntitys && that_present_TestEntitys))
                return false;
            if (!this.TestEntitys.equals(that.TestEntitys))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();

        boolean present_TestEntitys = true && (isSetTestEntitys());
        builder.append(present_TestEntitys);
        if (present_TestEntitys)
            builder.append(TestEntitys);

        return builder.toHashCode();
    }

    public int compareTo(TTestEntityList other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        TTestEntityList typedOther = (TTestEntityList)other;

        lastComparison = Boolean.valueOf(isSetTestEntitys()).compareTo(typedOther.isSetTestEntitys());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetTestEntitys()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.TestEntitys, typedOther.TestEntitys);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TTestEntityList(");
        boolean first = true;

        sb.append("TestEntitys:");
        if (this.TestEntitys == null) {
            sb.append("null");
        } else {
            sb.append(this.TestEntitys);
        }
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
        // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        try {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private static class TTestEntityListStandardSchemeFactory implements SchemeFactory {
        public TTestEntityListStandardScheme getScheme() {
            return new TTestEntityListStandardScheme();
        }
    }

    private static class TTestEntityListStandardScheme extends StandardScheme<TTestEntityList> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, TTestEntityList struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true)
            {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // TEST_ENTITYS
                        if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
                            {
                                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                                struct.TestEntitys = new ArrayList<TTestEntity>(_list0.size);
                                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                                {
                                    TTestEntity _elem2; // required
                                    _elem2 = new TTestEntity();
                                    _elem2.read(iprot);
                                    struct.TestEntitys.add(_elem2);
                                }
                                iprot.readListEnd();
                            }
                            struct.setTestEntitysIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();
            struct.validate();
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot, TTestEntityList struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            if (struct.TestEntitys != null) {
                oprot.writeFieldBegin(TEST_ENTITYS_FIELD_DESC);
                {
                    oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.TestEntitys.size()));
                    for (TTestEntity _iter3 : struct.TestEntitys)
                    {
                        _iter3.write(oprot);
                    }
                    oprot.writeListEnd();
                }
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class TTestEntityListTupleSchemeFactory implements SchemeFactory {
        public TTestEntityListTupleScheme getScheme() {
            return new TTestEntityListTupleScheme();
        }
    }

    private static class TTestEntityListTupleScheme extends TupleScheme<TTestEntityList> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, TTestEntityList struct) throws org.apache.thrift.TException {
            TTupleProtocol oprot = (TTupleProtocol) prot;
            BitSet optionals = new BitSet();
            if (struct.isSetTestEntitys()) {
                optionals.set(0);
            }
            oprot.writeBitSet(optionals, 1);
            if (struct.isSetTestEntitys()) {
                {
                    oprot.writeI32(struct.TestEntitys.size());
                    for (TTestEntity _iter4 : struct.TestEntitys)
                    {
                        _iter4.write(oprot);
                    }
                }
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, TTestEntityList struct) throws org.apache.thrift.TException {
            TTupleProtocol iprot = (TTupleProtocol) prot;
            BitSet incoming = iprot.readBitSet(1);
            if (incoming.get(0)) {
                {
                    org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
                    struct.TestEntitys = new ArrayList<TTestEntity>(_list5.size);
                    for (int _i6 = 0; _i6 < _list5.size; ++_i6)
                    {
                        TTestEntity _elem7; // required
                        _elem7 = new TTestEntity();
                        _elem7.read(iprot);
                        struct.TestEntitys.add(_elem7);
                    }
                }
                struct.setTestEntitysIsSet(true);
            }
        }
    }

}
