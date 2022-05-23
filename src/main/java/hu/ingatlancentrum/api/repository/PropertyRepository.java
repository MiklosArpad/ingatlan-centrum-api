package hu.ingatlancentrum.api.repository;

import hu.ingatlancentrum.api.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
