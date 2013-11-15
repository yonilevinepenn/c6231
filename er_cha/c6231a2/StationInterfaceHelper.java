package c6231;

/**
 * c6231/StationInterfaceHelper.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from Station.idl Thursday, October 24, 2013 2:04:03
 * PM EDT
 */
abstract public class StationInterfaceHelper {

    private static String _id = "IDL:c6231/StationInterface:1.0";

    public static void insert(org.omg.CORBA.Any a, c6231.StationInterface that) {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static c6231.StationInterface extract(org.omg.CORBA.Any a) {
        return read(a.create_input_stream());
    }
    private static org.omg.CORBA.TypeCode __typeCode = null;

    synchronized public static org.omg.CORBA.TypeCode type() {
        if (__typeCode == null) {
            __typeCode = org.omg.CORBA.ORB.init().create_interface_tc(c6231.StationInterfaceHelper.id(), "StationInterface");
        }
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static c6231.StationInterface read(org.omg.CORBA.portable.InputStream istream) {
        return narrow(istream.read_Object(_StationInterfaceStub.class));
    }

    public static void write(org.omg.CORBA.portable.OutputStream ostream, c6231.StationInterface value) {
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static c6231.StationInterface narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof c6231.StationInterface) {
            return (c6231.StationInterface) obj;
        } else if (!obj._is_a(id())) {
            throw new org.omg.CORBA.BAD_PARAM();
        } else {
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            c6231._StationInterfaceStub stub = new c6231._StationInterfaceStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static c6231.StationInterface unchecked_narrow(org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof c6231.StationInterface) {
            return (c6231.StationInterface) obj;
        } else {
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            c6231._StationInterfaceStub stub = new c6231._StationInterfaceStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }
}
