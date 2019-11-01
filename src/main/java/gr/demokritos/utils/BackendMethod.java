package gr.demokritos.utils;

public enum BackendMethod {
    RELATIONAL, MONGODB, REDIS, CASSANDRA, JSON;

    public static String getStringFromEnum(BackendMethod method) {
        switch (method) {
            case RELATIONAL:
                return RestApiConstants.RELATIONAL;
            case MONGODB:
                return RestApiConstants.MONGODB;
            case REDIS:
                return RestApiConstants.REDIS;
            case CASSANDRA:
                return RestApiConstants.CASSANDRA;
            case JSON:
                return RestApiConstants.JSON;
            default:
                return null;
        }
    }

    public static BackendMethod getEnumFromString(String method) {
        if(method.equalsIgnoreCase(RestApiConstants.RELATIONAL)) {
            return RELATIONAL;
        } else if (method.equalsIgnoreCase(RestApiConstants.MONGODB)) {
            return MONGODB;
        } else if (method.equalsIgnoreCase(RestApiConstants.CASSANDRA)) {
            return CASSANDRA;
        } else if (method.equalsIgnoreCase(RestApiConstants.REDIS)) {
            return REDIS;
        } else if (method.equalsIgnoreCase(RestApiConstants.JSON)) {
            return JSON;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return getStringFromEnum(this);
    }
}
