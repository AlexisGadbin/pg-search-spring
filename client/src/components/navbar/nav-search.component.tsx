import { Input } from '@components/ui/input'
import { useTranslations } from 'next-intl'

const NavSearch = () => {
  const t = useTranslations('nav.search')

  return (
    <div>
      <Input
        type="search"
        placeholder={t('placeholder')}
        className="md:w-[100px] lg:w-[300px]"
      />
    </div>
  )
}
export default NavSearch
