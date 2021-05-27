package com.golden.transport.util.service.Sserviceimpl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import com.golden.transport.util.service.Utilservice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

    @Component
    public class UtilserviceImpl implements Utilservice {

        Logger logger = Logger.getLogger(UtilserviceImpl.class.getName());


        public UtilserviceImpl() {
        }

        public String generateRandomSequence() {
            return UUID.randomUUID().toString();
        }

    }


