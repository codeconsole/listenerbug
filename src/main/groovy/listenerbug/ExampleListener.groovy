package listenerbug

import org.grails.datastore.mapping.core.Datastore
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEventListener
import org.grails.datastore.mapping.engine.event.EventType
import org.grails.datastore.mapping.engine.event.PreInsertEvent
import org.grails.datastore.mapping.engine.event.PreUpdateEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEvent
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic
class ExampleListener extends AbstractPersistenceEventListener {

    ExampleListener(final Datastore datastore) {
        super(datastore)
    }

    @Override
    @CompileStatic(TypeCheckingMode.SKIP) 
    protected void onPersistenceEvent(AbstractPersistenceEvent event) {
        def o = event.entityObject
        o.prop = 'autoset'
        println "Autoset"
    }

    @Override
    boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        eventType == PreUpdateEvent || eventType == PreInsertEvent
    }
}
