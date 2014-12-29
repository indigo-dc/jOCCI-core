package cz.cesnet.cloud.occi.core;

import cz.cesnet.cloud.occi.collection.SetCover;
import java.net.URI;
import java.util.Collection;
import java.util.Set;

public class Kind extends Category {

    private final SetCover<Kind> related = new SetCover<>();
    private String entityType;
    private Kind parentKind = null;

    public Kind(URI scheme, String term, String title, URI location, Collection<Attribute> attributes) {
        super(scheme, term, title, location, attributes);
    }

    public Kind(URI scheme, String term) {
        this(scheme, term, null, null, null);
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Kind getParentKind() {
        return parentKind;
    }

    public void setParentKind(Kind parentKind) {
        this.parentKind = parentKind;
    }

    public boolean relatesTo(Kind kind) {
        return related.contains(kind);
    }

    public boolean relatesTo(String kindIdentifier) {
        return related.contains(kindIdentifier);
    }

    public boolean addRelation(Kind kind) {
        return related.add(kind);
    }

    public Kind getRelatedKind(String kindIdentifier) {
        return related.get(kindIdentifier);
    }

    public boolean removeRelation(Kind kind) {
        return related.remove(kind);
    }

    public void clearRelations() {
        related.clear();
    }

    public Set<Kind> getRelations() {
        return related.getSet();
    }

    @Override
    public String toString() {
        return "Kind{" + "term=" + getTerm() + ", scheme=" + getScheme() + ", title=" + getTitle() + ", location=" + getLocation() + ", attributes=" + getAttributes() + ", related=" + related + '}';
    }
}
