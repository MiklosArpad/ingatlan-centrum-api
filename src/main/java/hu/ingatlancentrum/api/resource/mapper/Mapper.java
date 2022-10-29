package hu.ingatlancentrum.api.resource.mapper;

public interface Mapper<From, To> {
    To map(From from);
}
