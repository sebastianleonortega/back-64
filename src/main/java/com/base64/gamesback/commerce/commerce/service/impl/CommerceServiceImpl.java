package com.base64.gamesback.commerce.commerce.service.impl;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.entity.Commerce_;
import com.base64.gamesback.commerce.commerce.repository.CommerceRepository;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import com.base64.gamesback.common.exception.AlreadyExistException;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CommerceServiceImpl implements CommerceService {

    private final CommerceRepository commerceRepository;

    @PersistenceContext
    private EntityManager em;

    public CommerceServiceImpl(CommerceRepository commerceRepository) {
        this.commerceRepository = commerceRepository;
    }

    @Override
    public CommerceDto findCommerceById(UUID id) {
      return commerceRepository
              .findById(id)
              .map(commerce -> new CommerceDto(
                      commerce.getName(),
                      commerce.getNit(),
                      commerce.getAddress(),
                      commerce.getEmail(),
                      commerce.getPhone())
              ).orElseThrow(()-> new ResourceNotFoundException("No existe el comercio."));
    }

    @Override
    public Commerce getCommerceById(UUID id) {
        return commerceRepository.findById(id).orElseThrow(() -> new  ResourceNotFoundException("No existe el comercio."));
    }

    @Override
    public List<CommerceDto> getAllCommerce() {
        List<CommerceDto> result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<CommerceDto> cq = cb.createQuery(CommerceDto.class);
            Root<Commerce> root = cq.from(Commerce.class);

            cq.select(
                    cb.construct(
                            CommerceDto.class,
                            root.get(Commerce_.name),
                            root.get(Commerce_.nit),
                            root.get(Commerce_.address),
                            root.get(Commerce_.email),
                            root.get(Commerce_.phone)
                    )
            );
            result = em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            log.error("Error en la criteria ListAllCommerce [{}]", ex.getMessage());
        }
        return result;
    }

    @Override
    public void createCommerce(CommerceDto request) {
        if (commerceRepository.existsCommerceByNameIgnoreCase(request.getName().trim())) {
            throw new AlreadyExistException("Ya existe un comercio con este nombre.");
        }
        Commerce commerce = Commerce.create(
                request.getName(),
                request.getNit(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone()
        );
        commerceRepository.save(commerce);
    }

    @Override
    public void updateCommerce(UUID id, CommerceDto request) {
        if (commerceRepository.existsCommerceByNameIgnoreCaseAndCommerceIdNot(request.getName().trim(), id)) {
            throw new AlreadyExistException("Ya existe un comercio con este nombre.");
        }
        Commerce commerce = commerceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el comercio."));
        commerce.update(
                request.getName(),
                request.getNit(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone()
        );
        commerceRepository.save(commerce);
    }

    @Override
    public void deleteCommerceById(UUID id) {
       Commerce commerce = commerceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el comercio."));
        commerceRepository.delete(commerce);
    }
}
