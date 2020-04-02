/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id: MissingAddressingHeaderException.java 51050 2006-06-27 15:11:34Z af70133 $
 */

package com.sun.ts.tests.jaxws.wsa.common;

import jakarta.xml.ws.WebServiceException;
import javax.xml.namespace.QName;

public class MissingAddressingHeaderException extends WebServiceException {
  QName name;

  public MissingAddressingHeaderException(QName name) {
    this.name = name;
  }

  public QName getMapQName() {
    return name;
  }
}
