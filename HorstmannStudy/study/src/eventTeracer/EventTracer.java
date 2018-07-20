package eventTeracer;

import java.awt.*;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EventTracer {
    private InvocationHandler handler;

    public EventTracer() {
        //Handler wszystkich obiektow posrednich zdarzen
        handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method + ": " + args[0]);
                return null;
            }
        };
    }

    /**
     * DOdawanie obiektow sledzacych zdarenia dla wszystkich zdarzen,ktorych ten komponent
     * i jego potomkowie moga nasluchiwac
     *
     * @param c komponent
     */
    public void add(Component c) {
        try {
            //Pobranie wszystkich zdarzen ktorych ten komponent moze nasluchiwac
            BeanInfo info = Introspector.getBeanInfo(c.getClass());
            EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
            for (EventSetDescriptor eventSet : eventSets)
                addListener(c, eventSet);
        } catch (IntrospectionException e) {
        }
    }

    /**
     * DOdanie nasluchiwacza do danego zbioru zdarzen
     *
     * @param c        komponent
     * @param eventSet deskryptor interfejsu nasluchujacego
     */
    public void addListener(Component c, EventSetDescriptor eventSet) {
        //Utworzenie obiektu posredniego dlatego typu nasluchiwaczy i przekazanie wszystkich wywolan
        //do handlera

        Object proxy = Proxy.newProxyInstance(null, new Class[]{eventSet.getListenerType()}, handler);

        //Dodanie obiektu posredniego jako nasluchiwacza do komponentu
        Method addListenerMethod = eventSet.getAddListenerMethod();
        try {
            addListenerMethod.invoke(c, proxy);
        } catch (ReflectiveOperationException e) {

        }
    }

}
