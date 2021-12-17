package springBoard.Board.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import springBoard.Board.DTO.MemberDTO;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MemberJpaRepository implements MemberRepository{

    @Override
    public List<MemberDTO> findAll() {
        return null;
    }

    @Override
    public List<MemberDTO> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<MemberDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<MemberDTO> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(MemberDTO entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends MemberDTO> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends MemberDTO> S save(S entity) {
        return null;
    }

    @Override
    public <S extends MemberDTO> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<MemberDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends MemberDTO> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends MemberDTO> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<MemberDTO> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public MemberDTO getOne(Long aLong) {
        return null;
    }

    @Override
    public MemberDTO getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends MemberDTO> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MemberDTO> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends MemberDTO> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends MemberDTO> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MemberDTO> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MemberDTO> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends MemberDTO, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public MemberDTO findByMemberId(String memberId) {
        return null;
    }
}
