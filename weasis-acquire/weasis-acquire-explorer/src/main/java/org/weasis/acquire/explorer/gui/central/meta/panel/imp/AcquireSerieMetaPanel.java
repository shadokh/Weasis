/*******************************************************************************
 * Copyright (c) 2016 Weasis Team and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Roduit - initial API and implementation
 *******************************************************************************/
package org.weasis.acquire.explorer.gui.central.meta.panel.imp;

import org.weasis.acquire.explorer.Messages;
import org.weasis.acquire.explorer.core.bean.Serie;
import org.weasis.acquire.explorer.gui.central.meta.model.AcquireMetadataTableModel;
import org.weasis.acquire.explorer.gui.central.meta.model.imp.AcquireSerieMeta;
import org.weasis.acquire.explorer.gui.central.meta.panel.AcquireMetadataPanel;
import org.weasis.core.api.util.StringUtil;

public class AcquireSerieMetaPanel extends AcquireMetadataPanel {
    private static final long serialVersionUID = -2751941971479265507L;

    private static final String NO_SERIE = Messages.getString("AcquireSerieMetaPanel.no_series"); //$NON-NLS-1$
    private static final String SERIE_PREFIX = Messages.getString("AcquireSerieMetaPanel.series") + StringUtil.COLON_AND_SPACE; //$NON-NLS-1$

    protected Serie serie;

    public AcquireSerieMetaPanel(Serie serie) {
        super(""); //$NON-NLS-1$
        this.serie = serie;

    }

    @Override
    public AcquireMetadataTableModel newTableModel() {
        return new AcquireSerieMeta(serie);
    }

    @Override
    public String getDisplayText() {
        return (serie == null) ? NO_SERIE : new StringBuilder(SERIE_PREFIX).append(serie.getDisplayName()).toString();
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
        this.titleBorder.setTitle(getDisplayText());
        update();
    }

    @Override
    public void update() {
        setMetaVisible(serie != null);
        super.update();
    }

}
