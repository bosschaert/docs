/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors.
 * See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.quickstarts.webosgi.svc.impl;

import java.util.Random;

import org.jboss.as.quickstarts.webosgi.api.StockInfoService;
import org.jboss.as.quickstarts.webosgi.api.StockQuote;

/** A dummy Stock Info Service which returns random USD values
 *  with a fixed delay of 15 minutes.
 */
public class StockInfoServiceImpl implements StockInfoService {
    public static final long DELAY = 15;

    private Random random = new Random();

    public StockQuote getStockQuote(String symbol) {
        return new StockQuote() {
            public long getPrice() {
                return random.nextInt(10000) - 5000;
            }

            public String getCurrency() {
                return "USD";
            }

            public long getDelay() {
                return DELAY;
            }
        };
    }
}
