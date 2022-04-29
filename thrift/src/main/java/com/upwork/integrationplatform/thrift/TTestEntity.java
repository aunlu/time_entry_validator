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

public class TTestEntity implements org.apache.thrift.TBase<TTestEntity, TTestEntity._Fields>, java.io.Serializable, Cloneable {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTestEntity");

    private static final org.apache.thrift.protocol.TField UID_FIELD_DESC = new org.apache.thrift.protocol.TField("uid", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField CREATED_TS_FIELD_DESC = new org.apache.thrift.protocol.TField("createdTs", org.apache.thrift.protocol.TType.STRING, (short)2);
    private static final org.apache.thrift.protocol.TField UPDATED_TS_FIELD_DESC = new org.apache.thrift.protocol.TField("updatedTs", org.apache.thrift.protocol.TType.STRING, (short)3);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
        schemes.put(StandardScheme.class, new TTestEntityStandardSchemeFactory());
        schemes.put(TupleScheme.class, new TTestEntityTupleSchemeFactory());
    }

    private String uid; // required
    private String createdTs; // required
    private String updatedTs; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        UID((short)1, "uid"),
        CREATED_TS((short)2, "createdTs"),
        UPDATED_TS((short)3, "updatedTs");

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
                case 1: // UID
                    return UID;
                case 2: // CREATED_TS
                    return CREATED_TS;
                case 3: // UPDATED_TS
                    return UPDATED_TS;
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
        tmpMap.put(_Fields.UID, new org.apache.thrift.meta_data.FieldMetaData("uid", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "UID")));
        tmpMap.put(_Fields.CREATED_TS, new org.apache.thrift.meta_data.FieldMetaData("createdTs", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Timestamp")));
        tmpMap.put(_Fields.UPDATED_TS, new org.apache.thrift.meta_data.FieldMetaData("updatedTs", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Timestamp")));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTestEntity.class, metaDataMap);
    }

    public TTestEntity() {
    }

    public TTestEntity(
            String uid,
            String createdTs,
            String updatedTs)
    {
        this();
        this.uid = uid;
        this.createdTs = createdTs;
        this.updatedTs = updatedTs;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public TTestEntity(TTestEntity other) {
        if (other.isSetUid()) {
            this.uid = other.uid;
        }
        if (other.isSetCreatedTs()) {
            this.createdTs = other.createdTs;
        }
        if (other.isSetUpdatedTs()) {
            this.updatedTs = other.updatedTs;
        }
    }

    public TTestEntity deepCopy() {
        return new TTestEntity(this);
    }

    @Override
    public void clear() {
        this.uid = null;
        this.createdTs = null;
        this.updatedTs = null;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void unsetUid() {
        this.uid = null;
    }

    /** Returns true if field uid is set (has been assigned a value) and false otherwise */
    public boolean isSetUid() {
        return this.uid != null;
    }

    public void setUidIsSet(boolean value) {
        if (!value) {
            this.uid = null;
        }
    }

    public String getCreatedTs() {
        return this.createdTs;
    }

    public void setCreatedTs(String createdTs) {
        this.createdTs = createdTs;
    }

    public void unsetCreatedTs() {
        this.createdTs = null;
    }

    /** Returns true if field createdTs is set (has been assigned a value) and false otherwise */
    public boolean isSetCreatedTs() {
        return this.createdTs != null;
    }

    public void setCreatedTsIsSet(boolean value) {
        if (!value) {
            this.createdTs = null;
        }
    }

    public String getUpdatedTs() {
        return this.updatedTs;
    }

    public void setUpdatedTs(String updatedTs) {
        this.updatedTs = updatedTs;
    }

    public void unsetUpdatedTs() {
        this.updatedTs = null;
    }

    /** Returns true if field updatedTs is set (has been assigned a value) and false otherwise */
    public boolean isSetUpdatedTs() {
        return this.updatedTs != null;
    }

    public void setUpdatedTsIsSet(boolean value) {
        if (!value) {
            this.updatedTs = null;
        }
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case UID:
                if (value == null) {
                    unsetUid();
                } else {
                    setUid((String)value);
                }
                break;

            case CREATED_TS:
                if (value == null) {
                    unsetCreatedTs();
                } else {
                    setCreatedTs((String)value);
                }
                break;

            case UPDATED_TS:
                if (value == null) {
                    unsetUpdatedTs();
                } else {
                    setUpdatedTs((String)value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case UID:
                return getUid();

            case CREATED_TS:
                return getCreatedTs();

            case UPDATED_TS:
                return getUpdatedTs();

        }
        throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        switch (field) {
            case UID:
                return isSetUid();
            case CREATED_TS:
                return isSetCreatedTs();
            case UPDATED_TS:
                return isSetUpdatedTs();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof TTestEntity)
            return this.equals((TTestEntity)that);
        return false;
    }

    public boolean equals(TTestEntity that) {
        if (that == null)
            return false;

        boolean this_present_uid = true && this.isSetUid();
        boolean that_present_uid = true && that.isSetUid();
        if (this_present_uid || that_present_uid) {
            if (!(this_present_uid && that_present_uid))
                return false;
            if (!this.uid.equals(that.uid))
                return false;
        }

        boolean this_present_createdTs = true && this.isSetCreatedTs();
        boolean that_present_createdTs = true && that.isSetCreatedTs();
        if (this_present_createdTs || that_present_createdTs) {
            if (!(this_present_createdTs && that_present_createdTs))
                return false;
            if (!this.createdTs.equals(that.createdTs))
                return false;
        }

        boolean this_present_updatedTs = true && this.isSetUpdatedTs();
        boolean that_present_updatedTs = true && that.isSetUpdatedTs();
        if (this_present_updatedTs || that_present_updatedTs) {
            if (!(this_present_updatedTs && that_present_updatedTs))
                return false;
            if (!this.updatedTs.equals(that.updatedTs))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();

        boolean present_uid = true && (isSetUid());
        builder.append(present_uid);
        if (present_uid)
            builder.append(uid);

        boolean present_createdTs = true && (isSetCreatedTs());
        builder.append(present_createdTs);
        if (present_createdTs)
            builder.append(createdTs);

        boolean present_updatedTs = true && (isSetUpdatedTs());
        builder.append(present_updatedTs);
        if (present_updatedTs)
            builder.append(updatedTs);

        return builder.toHashCode();
    }

    public int compareTo(TTestEntity other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        TTestEntity typedOther = (TTestEntity)other;

        lastComparison = Boolean.valueOf(isSetUid()).compareTo(typedOther.isSetUid());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetUid()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uid, typedOther.uid);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetCreatedTs()).compareTo(typedOther.isSetCreatedTs());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetCreatedTs()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createdTs, typedOther.createdTs);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetUpdatedTs()).compareTo(typedOther.isSetUpdatedTs());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetUpdatedTs()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.updatedTs, typedOther.updatedTs);
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
        StringBuilder sb = new StringBuilder("TTestEntity(");
        boolean first = true;

        sb.append("uid:");
        if (this.uid == null) {
            sb.append("null");
        } else {
            sb.append(this.uid);
        }
        first = false;
        if (!first) sb.append(", ");
        sb.append("createdTs:");
        if (this.createdTs == null) {
            sb.append("null");
        } else {
            sb.append(this.createdTs);
        }
        first = false;
        if (!first) sb.append(", ");
        sb.append("updatedTs:");
        if (this.updatedTs == null) {
            sb.append("null");
        } else {
            sb.append(this.updatedTs);
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

    private static class TTestEntityStandardSchemeFactory implements SchemeFactory {
        public TTestEntityStandardScheme getScheme() {
            return new TTestEntityStandardScheme();
        }
    }

    private static class TTestEntityStandardScheme extends StandardScheme<TTestEntity> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, TTestEntity struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true)
            {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // UID
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.uid = iprot.readString();
                            struct.setUidIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // CREATED_TS
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.createdTs = iprot.readString();
                            struct.setCreatedTsIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // UPDATED_TS
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.updatedTs = iprot.readString();
                            struct.setUpdatedTsIsSet(true);
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

        public void write(org.apache.thrift.protocol.TProtocol oprot, TTestEntity struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            if (struct.uid != null) {
                oprot.writeFieldBegin(UID_FIELD_DESC);
                oprot.writeString(struct.uid);
                oprot.writeFieldEnd();
            }
            if (struct.createdTs != null) {
                oprot.writeFieldBegin(CREATED_TS_FIELD_DESC);
                oprot.writeString(struct.createdTs);
                oprot.writeFieldEnd();
            }
            if (struct.updatedTs != null) {
                oprot.writeFieldBegin(UPDATED_TS_FIELD_DESC);
                oprot.writeString(struct.updatedTs);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class TTestEntityTupleSchemeFactory implements SchemeFactory {
        public TTestEntityTupleScheme getScheme() {
            return new TTestEntityTupleScheme();
        }
    }

    private static class TTestEntityTupleScheme extends TupleScheme<TTestEntity> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, TTestEntity struct) throws org.apache.thrift.TException {
            TTupleProtocol oprot = (TTupleProtocol) prot;
            BitSet optionals = new BitSet();
            if (struct.isSetUid()) {
                optionals.set(0);
            }
            if (struct.isSetCreatedTs()) {
                optionals.set(1);
            }
            if (struct.isSetUpdatedTs()) {
                optionals.set(2);
            }
            oprot.writeBitSet(optionals, 3);
            if (struct.isSetUid()) {
                oprot.writeString(struct.uid);
            }
            if (struct.isSetCreatedTs()) {
                oprot.writeString(struct.createdTs);
            }
            if (struct.isSetUpdatedTs()) {
                oprot.writeString(struct.updatedTs);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, TTestEntity struct) throws org.apache.thrift.TException {
            TTupleProtocol iprot = (TTupleProtocol) prot;
            BitSet incoming = iprot.readBitSet(3);
            if (incoming.get(0)) {
                struct.uid = iprot.readString();
                struct.setUidIsSet(true);
            }
            if (incoming.get(1)) {
                struct.createdTs = iprot.readString();
                struct.setCreatedTsIsSet(true);
            }
            if (incoming.get(2)) {
                struct.updatedTs = iprot.readString();
                struct.setUpdatedTsIsSet(true);
            }
        }
    }

}
